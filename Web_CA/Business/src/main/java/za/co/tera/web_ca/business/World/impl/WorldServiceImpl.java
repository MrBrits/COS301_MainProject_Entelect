package za.co.tera.web_ca.business.World.impl;

import jdk.internal.org.xml.sax.SAXParseException;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import za.co.tera.web_ca.business.World.base.WorldService;
import za.co.tera.web_ca.data_access.CoordinateDao;
import za.co.tera.web_ca.data_access.WorldDao;
import za.co.tera.web_ca.data_access.impl.CoordinateDaoImpl;
import za.co.tera.web_ca.data_access.impl.WorldDaoImpl;
import za.co.tera.web_ca.domain.impl.Coordinate;
import za.co.tera.web_ca.domain.impl.World;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WorldServiceImpl implements WorldService{
    private WorldDao worldDAO = new WorldDaoImpl();
    private CoordinateDao coordinateDao = new CoordinateDaoImpl();

    public int createWorld(World newWorld)
    {
        World world;

        world = worldDAO.save(newWorld);
        Writer writer = null;

        try {


            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newWorld.getWorldId()+".xml"), "utf-8"));
            writer.write("<coordinateList>\n");
            for (int i = 0; i < world.getWorldHeight(); i++) {

                for (int j = 0; j < world.getWorldHeight(); j++) {
                    System.out.println("dsfdf");
                    for (int k = 0; k < world.getWorldDepth(); k++) {
                        writer.write("<coordinate>\n");
                        writer.write("<x>"+i+"</x>\n");
                        writer.write("<y>"+j+"</y>\n");
                        writer.write("<z>"+k+"</z>\n");
                        writer.write("<value>"+k+"</value>\n");
                        writer.write("</coordinate>\n");
                    }
                }

            }
            writer.write("</coordinateList>\n");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {

            try {writer.close();} catch (Exception ex) { System.out.println(ex.getMessage());}
        }
        return world.getOwnerId();
    }


    public void deleteWorld(World delWorld)
    {
        worldDAO.delete(delWorld);
    }

    public void updateWorld(World updateWorld)
    {
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
        List<World> worldList = worldDAO.findWorldByUserId(ID);
        return  worldList;
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
                    int v =Integer.parseInt(eElement.getElementsByTagName("value").item(0).getTextContent());

                    Coordinate newCoordinate= new Coordinate(x,y,z,v,worldId);
                    coordinateList.add(newCoordinate);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }return coordinateList;
    }
}
