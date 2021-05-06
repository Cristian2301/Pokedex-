package Files;

import java.io.File;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import Pokedex.*;
import domain.Abilitie;
import domain.Evolution;
import domain.Pokemon;
import domain.eType;
 

public class FileHandler implements Files {

	public FileHandler() {
	}

	
	@Override
	/**
	 * Creates an xml file in case it does not exists, transforms the pokemon's attributes into nodes and then writes those nodes
	 * into the file, creating an xml object.
	 * @param Gets the name of the file to be written.
	 * @param Gets the list of pokemons to write in the file.
	 * @return Returns true if the file was written correctly.
	 */
	public boolean writePokXml(String fileName, List<Pokemon> pokList){
		
		boolean ret = false;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document doc = implementation.createDocument(null, fileName, null);
			doc.setXmlVersion("1.0");
			
			Element root = doc.getDocumentElement();
            //For each pokemon we create it's attributes.
            for(int i = 0; i < pokList.size(); i++){
            	
                //Pokemon Node
                Element pokemonNode = doc.createElement("Pokemon"); 
                
                //Name Node
                Element nameNode = doc.createElement("Name"); 
                Text nodeNameValue = doc.createTextNode(pokList.get(i).getName());
                nameNode.appendChild(nodeNameValue);      
                
                //Type Node
                Element typeNode = doc.createElement("Type"); 
                Text nodeTypeValue = doc.createTextNode("" + pokList.get(i).getType().toString());                
                typeNode.appendChild(nodeTypeValue);
                
                //Level Node
                Element levelNode = doc.createElement("Level"); 
                Text nodeLevelValue = doc.createTextNode("" + pokList.get(i).getLevel());                
                levelNode.appendChild(nodeLevelValue);
                
                //PokID Node
                Element idNode = doc.createElement("PokemonID"); 
                Text nodeIdValue = doc.createTextNode("" + pokList.get(i).getPokID());                
                idNode.appendChild(nodeIdValue);
                
                
                //Abilities Node
                Element abNode = doc.createElement("Abilitie"); 
                
                	for(Abilitie a: pokList.get(i).getAbilities()) {
                	                	
                	Element abNameNode = doc.createElement("AbilitieName"); 
                	Text nodeAbNameValue = doc.createTextNode("" + a.getName());                
                	abNameNode.appendChild(nodeAbNameValue);
                	
                	Element abTypeNode = doc.createElement("AbilitieType");
                	Text nodeAbTypeValue = doc.createTextNode("" + a.getType());                
                	abTypeNode.appendChild(nodeAbTypeValue);  
                	
                	abNode.appendChild(abNameNode);
                	abNode.appendChild(abTypeNode);
                }
                
                //append nodes to the pokemon Node
                pokemonNode.appendChild(nameNode);
                pokemonNode.appendChild(typeNode);
                pokemonNode.appendChild(levelNode);
                pokemonNode.appendChild(idNode);
                pokemonNode.appendChild(abNode);
                
                //append itemNode to raiz
                root.appendChild(pokemonNode); //pegamos el elemento a la raiz "Documento"
            }
            //Generating the xml file.
            Source source = new DOMSource(doc);
            
            //Where do we store the file
            Result result = new StreamResult(new java.io.File(fileName+".xml")); //Name of the file
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            ret = true;
            
		}catch(Exception ex){
			System.out.print("Pokedex couldn't be saved");
		}
		return ret;
	}
	
	@Override
	/**
	 * Creates an xml file in case it does not exists, transforms the evolution's attributes into nodes and then writes those nodes
	 * into the file, creating an xml object.
	 * @param Gets the name of the file to be written.
	 * @param Gets the list of evolutions to write in the file.
	 * @return Returns true if the file was written correctly.
	 */
	public boolean writeEvoXml(String fileName, List<Evolution> evoList){
		
		boolean ret = false;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document doc = implementation.createDocument(null, fileName, null);
			doc.setXmlVersion("1.0");
			
			Element root = doc.getDocumentElement();
            //For each evolution we create it's attributes.
            for(int i = 0; i < evoList.size(); i++){
            	
                //Evolution Node
                Element evolutionnNode = doc.createElement("Evolution"); 
                
                //Name Node
                Element nameNode = doc.createElement("Name"); 
                Text nodeNameValue = doc.createTextNode("" + evoList.get(i).getName());
                nameNode.appendChild(nodeNameValue);      
                
                //Type Node
                Element typeNode = doc.createElement("Type"); 
                Text nodeTypeValue = doc.createTextNode("" + evoList.get(i).getType().toString());                
                typeNode.appendChild(nodeTypeValue);
                
                //Level Node
                Element levelNode = doc.createElement("LevelToEvolution"); 
                Text nodeLevelValue = doc.createTextNode("" + evoList.get(i).getLevelToEvolution());                
                levelNode.appendChild(nodeLevelValue);
                
                //PokID Node
                Element pokIdNode = doc.createElement("PokemonID"); 
                Text nodePokIdValue = doc.createTextNode("" + evoList.get(i).getPokID());                
                pokIdNode.appendChild(nodePokIdValue);
                
                //EvoId Node
                Element evoIdNode = doc.createElement("EvolutionID"); 
                Text nodeEvoIdValue = doc.createTextNode("" + evoList.get(i).getEvoID());                
                evoIdNode.appendChild(nodeEvoIdValue);
                
                //Abilities Node
                
                Element abNode = doc.createElement("Abilitie");
                
            	for(Abilitie a: evoList.get(i).getAbilities()) {
            	                	
            	Element abNameNode = doc.createElement("AbilitieName"); 
            	Text nodeAbNameValue = doc.createTextNode("" + a.getName());                
            	abNameNode.appendChild(nodeAbNameValue);
            	
            	Element abTypeNode = doc.createElement("AbilitieType");
            	Text nodeAbTypeValue = doc.createTextNode("" + a.getType());                
            	abTypeNode.appendChild(nodeAbTypeValue);  
            	
            	abNode.appendChild(abNameNode);
            	abNode.appendChild(abTypeNode);
            	}
                
                //append nodes to the pokemon Node
                evolutionnNode.appendChild(nameNode);
                evolutionnNode.appendChild(typeNode);
                evolutionnNode.appendChild(levelNode);
                evolutionnNode.appendChild(pokIdNode);
                evolutionnNode.appendChild(evoIdNode);
                evolutionnNode.appendChild(abNode);
                
                //append itemNode to raiz
                root.appendChild(evolutionnNode); //pegamos el elemento a la raiz "Documento"
            }
            
            //Generating the xml file.
            Source source = new DOMSource(doc);
            
            //Where do we store the file
            Result result = new StreamResult(new java.io.File(fileName+".xml")); //Name of the file
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            ret = true;
            
		}catch(Exception ex){
			System.out.print("Pokedex couldn't be saved");
		}
		return ret;
	}
	
	@Override
	/**
	 * Reads an XML file and builds each pokemon object with the xml nodes. 
	 * @return Returns the list of pokemons to be worked with in the pokedex.
	 */
	public List<Pokemon> readPokemonXml(){
		
		List<Pokemon> pokemonList = new ArrayList<Pokemon>();
		
		try {
            File file = new File("pokemons.xml");
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            
            document.getDocumentElement().normalize();
         
            NodeList pokList = document.getElementsByTagName("Pokemon"); 
            
            for(int i = 0 ; i < pokList.getLength() ; i++) { 
            	
                Node node = pokList.item(i); 
                
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                	
                    Element element = (Element) node;
                    
                    eType type;
                    String typeString;
                    List<Abilitie> abs = new ArrayList<Abilitie>();
                    
                    String abName; 
                    String abTypeString; 
                    eType abType;
                    
                    abName = element.getElementsByTagName("AbilitieName").item(0).getTextContent();
                    abTypeString = element.getElementsByTagName("AbilitieType").item(0).getTextContent();
                    abType = eType.valueOf(abTypeString);
                    
                    Abilitie ab = new Abilitie(abName, abType);
                    abs.add(ab);
                    
                    typeString = element.getElementsByTagName("Type").item(0).getTextContent();
                    type = eType.valueOf(typeString);
                    
                    Pokemon p = new Pokemon(element.getElementsByTagName("Name").item(0).getTextContent(), 
                    			type, 
                    			Integer.parseInt(element.getElementsByTagName("Level").item(0).getTextContent()), 
                    			abs);
                    
                    p.setPokID(Integer.parseInt(element.getElementsByTagName("PokemonID").item(0).getTextContent()));						
                    pokemonList.add(p);		
                }
            }
            
        } catch(Exception e) {
            System.out.print("Error reading the file");
        }
		return pokemonList;
	}
	
	@Override
	/**
	 * Reads an XML file and builds each evolution object with the xml nodes. 
	 * @return Returns the list of evolutions to be worked with in the pokedex.
	 */
	public List<Evolution> readEvolutionXml(){
		
		List<Evolution> evolutionList = new ArrayList<Evolution>();
		
		try {
            File file = new File("evolutions.xml");
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            
            document.getDocumentElement().normalize();
         
            NodeList evoList = document.getElementsByTagName("Evolution");
            
            for(int i = 0 ; i < evoList.getLength() ; i++) {
            	
                Node node = evoList.item(i);
                
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                	
                    Element element = (Element) node;
                    
                    eType type;
                    String typeString;
                    int pokID;
                    
                    List<Abilitie> abs = new ArrayList<Abilitie>();
                    String abName; 
                    String abTypeString; 
                    eType abType;
                    
                    abName = element.getElementsByTagName("AbilitieName").item(0).getTextContent();
                    abTypeString = element.getElementsByTagName("AbilitieType").item(0).getTextContent();
                    abType = eType.valueOf(abTypeString);
                    
                    Abilitie ab = new Abilitie(abName, abType);
                    abs.add(ab);
                    
                    pokID = Integer.parseInt(element.getElementsByTagName("PokemonID").item(0).getTextContent());
                    typeString = element.getElementsByTagName("Type").item(0).getTextContent();
                    type = eType.valueOf(typeString);
                    
                    Evolution p = new Evolution(element.getElementsByTagName("Name").item(0).getTextContent(), 
                    						Integer.parseInt(element.getElementsByTagName("LevelToEvolution").item(0).getTextContent()), 
                    						pokID, 
                    						Integer.parseInt(element.getElementsByTagName("EvolutionID").item(0).getTextContent()), 
                    						abs, 
                    						type);
                    						
                    evolutionList.add(p);		
                }
            }
            
        } catch(Exception e) {
            System.out.print("Error reading the file");
        }
		return evolutionList;
	}
}