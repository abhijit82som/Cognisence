package util.business;
import java.io.File;
import java.io.IOException;
 




import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import util.staticData;
 
/**
* Java Program to parse/read HTML documents from File using Jsoup library.
* Jsoup is an open source library which allows Java developer to parse HTML
* files and extract elements, manipulate data, change style using DOM, CSS and
* JQuery like method.
*
* @author Abhijit Som
*/
public class ReportParser{
 
	 public static String  statSender() {

        Document htmlFile = null;
        String UserType = staticData.userType;
		String platform = staticData.enviormentUnderTest;

        try {

          //   htmlFile = Jsoup.parse(new File("./Reports/"+platform+"/TestReports_" + util.general.ElementUtil.getDate("yyyy-MM-dd")+"/tag-overview.html"), "ISO-8859-1");
             htmlFile = Jsoup.parse(new File("./Reports/"+platform+"/TestReports_" + util.general.ElementUtil.getDate("yyyy-MM-dd")+"/feature-overview.html"), "ISO-8859-1");//abhijit
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 

        Elements div1 = htmlFile.getElementsByClass("stats-table");

        /*********************************************************************************************************************/
      String firstPart =  "<!DOCTYPE html>" + 
        "<html lang=\"en-US\">" + 
        "<head>" + 
          "<title>Test Result Statistics</title>" +
        "</head>" +
        "<style>" + 
        "table, th, td { " +
            "border: 1px solid black;" +
            "border-collapse: collapse;" +
        "}" +
        "th, td {" +
            "padding: 5px;" +
            "text-align: left;" +    
        "}" +
        "table.stats-table {" +
            "color: black;" +
            "border-width: 1px;" +
            "border-spacing: 2px;" +
            "border-style: outset;" +
            "border-color: gray;" +
            "border-collapse: collapse;" +
            "background-color: white;" +
        	"}" +
        	"table.stats-table th {" +
            "color: black;" +
            "border-width: 1px;" +
            "padding: 1px;" +
            "border-style: inset;" +
            "border-color: gray;" +
            "background-color: #66CCEE;" +
        "</style>" +
        "</head>" +
        "<body>" +
        "<h2>"+util.excelDataProvider.getCellValueByFieldName("Suit To Run", staticData.suitDataSheetName)+" Test Result For " + platform +  " For : " +UserType + " URL : " + util.business.enviormentDetails.connURL()[0]+"</h2>" +
        "<h2>Tag Statistics:</h2>" +
        "<table class=\"stats-table\">";
        /*********************************************************************************************************************/
      String middlePart = div1.html();
      middlePart.replace(middlePart, "<tbody>");
      middlePart.replace(middlePart, "</tbody>");
      
      
      String lastPart = "</body></HTML>"+"<br><br>" +"Regards," + "<br>" + "Automation Team <br><br>N.B: Please do not reply to this auto-generated mail";

      String fullHTML = firstPart + middlePart +lastPart;
      return fullHTML;
    }
 
}