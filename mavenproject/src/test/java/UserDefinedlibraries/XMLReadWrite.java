package UserDefinedlibraries;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReadWrite {
	
	static String n;
	public static String amount,TargetMonth,Targetday,RecipientName,RecipientEmail;
	
	public String readxml(String keyword){
		
		try{
			String filePath="C:\\Users\\NISHANTH\\eclipse-workspace1\\Alpha\\src\\test\\java\\TestData\\XMLData.xml";
			File file=new File(filePath);
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder=dbf.newDocumentBuilder();
			Document doc=dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("CabDetails");
			int tLength = nodeList.getLength();
			for(int i=0; i<tLength; i++){
			Node node = nodeList.item(i);
			if(node.getNodeType()==Node.ELEMENT_NODE){
			Element element = (Element)node;
			n=element.getElementsByTagName(keyword).item(0).getTextContent();
			}
		}
	}catch(Exception e){
		e.printStackTrace();
	}
		return n;
		}
	
	
	public static void read() {
		XMLReadWrite e = new XMLReadWrite();
		amount=e.readxml("amount");
		TargetMonth=e.readxml("TargetMonth");
		Targetday=e.readxml("Targetday");
		RecipientName=e.readxml("RecipientName");
		RecipientEmail=e.readxml("RecipientEmail");
	}
	public static void writexml(){
		CreateAXmlFile("TestCases.xml");
	}
	public static void CreateAXmlFile(String fileName){
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("TestCases");
            doc.appendChild(rootElement);
            Element test = doc.createElement("Test");
            rootElement.appendChild(test);
            Attr attr = doc.createAttribute("id");
            attr.setValue("1");
            test.setAttributeNode(attr);
            
            Element From = doc.createElement("From");
            From.appendChild(doc.createTextNode("Delhi"));
            test.appendChild(From);
            
            Element To = doc.createElement("To");
            To.appendChild(doc.createTextNode("Manali, Himachal Pradesh"));
            test.appendChild(To);
            
            Element TravelMonth = doc.createElement("TravelMonth");
            TravelMonth.appendChild(doc.createTextNode("July 2020"));
            test.appendChild(TravelMonth); 
            
            Element TravelDate = doc.createElement("TravelDate");
            TravelDate.appendChild(doc.createTextNode("21"));
            test.appendChild(TravelDate);
            
            Element PickUpTime = doc.createElement("PickUpTime");
            PickUpTime.appendChild(doc.createTextNode("06:30 AM"));
            test.appendChild(PickUpTime);
            
            Element CabType = doc.createElement("CabType");
            CabType.appendChild(doc.createTextNode("Suv"));
            test.appendChild(CabType);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(System.getProperty("user.dir")+File.separator+fileName));

            transformer.transform(source, result);

         System.out.println("File saved!");

     } catch (ParserConfigurationException pce) {
         pce.printStackTrace();
     } catch (TransformerException tfe) {
         tfe.printStackTrace();
     }
 }

}