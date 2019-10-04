package com.utilities;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * This class is used to modify the SP and IDP metadata.
 * @author jitendrk
 *
 */
public class ModifyXMLFile {

    private static String filepath;
    private static String tagName;
    private static String serviceUrl;
    private static String singleLogoutUrl ;
    private static DocumentBuilderFactory docFactory;
    private static DocumentBuilder docBuilder;
    private static Document doc;
    private static Node node;
    private static NamedNodeMap namedNodeMap;
    private static Node nodeAttribute;

    /**
     * This method is used to create the XML metadata for SP and IDP configuration.
     * @param instanceUrl
     * @param configuration
     */
    public static void createMetaDataXML(String instanceUrl, String configuration) {
        try {
            singleLogoutUrl = instanceUrl.replace("identity", "broker");
            if(configuration.equalsIgnoreCase("SP")) {
                filepath = "tib_metadata_for_sp.xml";
                tagName = "md:SingleSignOnService";
                serviceUrl = instanceUrl.replace("identity", "broker") + "/fed/app/idp.saml20.sso";
                singleLogoutUrl = singleLogoutUrl + "/fed/app/sp.saml20.slo";
            }else {
                filepath = "tib_metadata_for_idp.xml";
                tagName = "md:AssertionConsumerService";
                serviceUrl = instanceUrl.replace("identity", "broker") + "/fed/app/sp.saml20";
                singleLogoutUrl =singleLogoutUrl + "/fed/app/sp.consumeslo";
            }
            docFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(filepath);

            if(configuration.equalsIgnoreCase("SP")) {
                String attributeServiceUrl = instanceUrl.replace("identity", "broker") +
                        "/fedhttp://idp.cisco.com:8090/openam/AttributeServiceSoap/default/metaAlias/attra";
                replaceTagValueInXmlFile("md:AttributeService", "Location", attributeServiceUrl, 0);
            }

            /* Replace EntityDescriptor value in xml file*/
            replaceTagValueInXmlFile("md:EntityDescriptor", "entityID", instanceUrl.replace("identity", "broker") + "/admin", 0);


            /* Replace SingleLogoutService value in xml file*/
            replaceTagValueInXmlFile("md:SingleLogoutService", "Location", singleLogoutUrl, 0);

            /* Replace SingleSignOnService value in xml file*/
            replaceTagValueInXmlFile(tagName, "Location", serviceUrl, 0);

            /* Replace SingleSignOnService value in xml file*/
            replaceTagValueInXmlFile(tagName, "Location", serviceUrl, 1);

            /* Write the content into tib.xml file */
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
    }

    /**
     * This method search for the tag and replace those tag values with the new value.
     * @param tagName
     * @param itemName
     * @param contextText
     * @param itemNum
     */
    private static void replaceTagValueInXmlFile(String tagName, String itemName, String contextText, int itemNum) {
        node = doc.getElementsByTagName(tagName).item(itemNum);
        namedNodeMap = node.getAttributes();
        nodeAttribute = namedNodeMap.getNamedItem(itemName);
        nodeAttribute.setTextContent(contextText);
    }
}
