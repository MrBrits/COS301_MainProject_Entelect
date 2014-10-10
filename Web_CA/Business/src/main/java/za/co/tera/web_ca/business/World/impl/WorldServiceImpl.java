package za.co.tera.web_ca.business.World.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import za.co.tera.web_ca.business.World.base.WorldService;
import za.co.tera.web_ca.data_access.*;
import za.co.tera.web_ca.data_access.impl.*;
import za.co.tera.web_ca.domain.impl.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class WorldServiceImpl implements WorldService{
    private WorldDao worldDAO = new WorldDaoImpl();
    private CoordinateDao coordinateDao = new CoordinateDaoImpl();
    private WorldRulesDao worldrulesDao = new WorldRulesDaoImpl();
    private RuleDao ruleDao = new RuleDaoImpl();
    private RuleConditionDao ruleConditionDao = new RuleConditionDaoImpl();
    private RuleResultDao ruleResultDao = new RuleResultDaoImpl();
    RuleNeighboursDao ruleNeighboursDao = new RuleNeighboursDaoImpl();
    public int createWorld(World newWorld)
    {
        int ID = newWorld.getOwnerId();
        ID = (ID + 321)/369;
        newWorld.setOwnerId(ID);
        Writer writer = null;

        World world = worldDAO.save(newWorld);

        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(world.getWorldId()+".xml"), "utf-8"));
            writer.write("<coordinateList>\n");
            for (int x = 0; x < world.getWorldWidth(); x++) {
                for (int y = 0; y < world.getWorldHeight(); y++) {
                    for (int z = 0; z < world.getWorldDepth(); z++) {
                        writer.write("<coordinate>\n");
                        writer.write("<x>"+x+"</x>\n");
                        writer.write("<y>"+y+"</y>\n");
                        writer.write("<z>"+z+"</z>\n");
                        writer.write("<value>"+0+"</value>\n");
                        writer.write("</coordinate>\n");
                    }
                }
            }
            writer.write("</coordinateList>\n");



        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return world.getWorldId();
    }


    public void deleteWorld(World delWorld)
    {
        worldDAO.delete(delWorld);
    }

    public void updateWorld(World updateWorld)
    {
        int ID = updateWorld.getOwnerId();
        ID = (ID + 321)/369;
        updateWorld.setOwnerId(ID);
        worldDAO.save(updateWorld);
    }

    public World findWorld(int ID)
    {
        return worldDAO.findById(ID);
    }

    public List<World> findAllWorlds()  {
        List<World> worldList = worldDAO.findAll();
        return  worldList;
    }

    @Override
    public List<World> findWorldByUserId(int ID) {
        ID = (ID + 321)/369;
        List<World> worldList = worldDAO.findWorldByUserId(ID);
        return  worldList;
    }
    @Override
    public List<World> findWorldNotByUserId(int ID) {
        ID = (ID + 321)/369;
        List<World> worldList = worldDAO.findWorldNotByUserId(ID);
        return  worldList;
    }

    @Override
    public void ImportWorld(int newOwner,int worldId) throws IOException {

        World world= worldDAO.findById(worldId);
        int ID = newOwner;
        ID = (ID + 321)/369;

        world.setOwnerId(ID);

        world.setWorldId(0);
        int save= worldDAO.save(world).getWorldId();
        File source=new File(worldId+".xml");
        File destination=new File(save+".xml");
        copyFile(source,destination);

        List<Worldrules> worldrulesList =worldrulesDao.findRuleByWorldId(worldId);
        for(Worldrules worldrules:worldrulesList)
        {
            Rule rule =ruleDao.findById(worldrules.getRuleId());
            rule.setOwnerId(ID);
            rule.setRuleId(0);
            Rulecondition rulecondition= ruleConditionDao.findById(rule.getRuleConId());
            rulecondition.setRuleConditionId(0);
            int rulecon=ruleConditionDao.save(rulecondition).getRuleConditionId();
            rule.setRuleConId(rulecon);
            if(rule.getRuleConAndid()!=null)
            {
                Rulecondition ruleconditionAnd= ruleConditionDao.findById(rule.getRuleConAndid());
                ruleconditionAnd.setRuleConditionId(0);
                int ruleconAnd=ruleConditionDao.save(ruleconditionAnd).getRuleConditionId();
                rule.setRuleConAndid(ruleconAnd);
            }

            if(rule.getRuleConOrid()!=null)
            {

                Rulecondition ruleconditionOr= ruleConditionDao.findById(rule.getRuleConAndid());
                ruleconditionOr.setRuleConditionId(0);
                int ruleconOr=ruleConditionDao.save(ruleconditionOr).getRuleConditionId();
                rule.setRuleConOrid(ruleconOr);
            }
            Ruleresult ruleresult= ruleResultDao.findById(rule.getRuleResId());
            ruleresult.setRuleResultId(0);
            int ruleResult=ruleResultDao.save(ruleresult).getRuleResultId();
            rule.setRuleId(ruleResult);
            Rule ruleNew =ruleDao.save(rule);

            worldrules.setWorldRulesId(0);
            worldrules.setWorldId(save);
            worldrules.setRuleId(ruleNew.getRuleId());
            worldrulesDao.save(worldrules);

        }

    }

    @Override
    public void SaveWorldRules(List<Worldrules> worldrulesList) {
        for (Worldrules worldrules:worldrulesList)
                worldrulesDao.save(worldrules);
    }

    @Override
    public List<Ruleneighbours> findNeighbours() {
        return ruleNeighboursDao.findAll();
    }

    private static void copyFile(File sourceFile, File destFile) throws IOException {
        if(!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new RandomAccessFile(sourceFile,"rw").getChannel();
            destination = new RandomAccessFile(destFile,"rw").getChannel();

            long position = 0;
            long count    = source.size();

            source.transferTo(position, count, destination);
        }
        finally {
            if(source != null) {
                source.close();
            }
            if(destination != null) {
                destination.close();
            }
        }
    }

    @Override
    public void updateCoordinates(List<Coordinate> coordinateList) {
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(coordinateList.get(0).getWorldId()+".xml"), "utf-8"));
            writer.write("<coordinateList>\n");
            for (int x = 0; x < coordinateList.size(); x++) {

                        writer.write("<coordinate>\n");
                        writer.write("<x>"+coordinateList.get(x).getCoordinateX()+"</x>\n");
                        writer.write("<y>"+coordinateList.get(x).getCoordinateY()+"</y>\n");
                        writer.write("<z>"+coordinateList.get(x).getCoordinateZ()+"</z>\n");
                        writer.write("<value>"+coordinateList.get(x).getValue()+"</value>\n");
                        writer.write("</coordinate>\n");
            }
            writer.write("</coordinateList>\n");



        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public List<Coordinate> findCoordinateByWorldId(int worldId) {
        List<Coordinate> coordinateList = new ArrayList<Coordinate>();
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc =  dBuilder.parse(worldId+".xml");
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("coordinate");
            for (int temp = 0; temp < nList.getLength(); temp++)
            {
                Node nNode =  nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    int x =Integer.parseInt(eElement.getElementsByTagName("x").item(0).getTextContent());
                    int y =Integer.parseInt(eElement.getElementsByTagName("y").item(0).getTextContent());
                    int z =Integer.parseInt(eElement.getElementsByTagName("z").item(0).getTextContent());
                    double v = Double.parseDouble(eElement.getElementsByTagName("value").item(0).getTextContent());

                    Coordinate newCoordinate= new Coordinate(x,y,z,v,worldId);
                    coordinateList.add(newCoordinate);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }return coordinateList;
    }
}
