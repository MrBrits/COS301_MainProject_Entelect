package za.co.tera.web_ca.business.World.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import za.co.tera.web_ca.business.World.base.WorldService;
import za.co.tera.web_ca.data_access.CoordinateDao;
import za.co.tera.web_ca.data_access.WorldDao;
import za.co.tera.web_ca.data_access.impl.CoordinateDaoImpl;
import za.co.tera.web_ca.data_access.impl.WorldDaoImpl;
import za.co.tera.web_ca.domain.impl.Coordinate;
import za.co.tera.web_ca.domain.impl.World;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WorldServiceImpl implements WorldService{
    private WorldDao worldDAO = new WorldDaoImpl();
    private CoordinateDao coordinateDao = new CoordinateDaoImpl();

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
