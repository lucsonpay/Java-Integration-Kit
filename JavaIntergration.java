import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import com.xyz.commons.crypto.ChecksumUtils;

public class JavaIntergration {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("AMOUNT", "100");  // 100 = 1 Rs
		map.put("CURRENCY_CODE", "356");
		map.put("CUST_EMAIL", "customer@gamil.com");
		map.put("CUST_NAME", "DEMO");
		map.put("CUST_PHONE", "8888888888");
		map.put("CUST_STREET_ADDRESS1", "XYZ");
		map.put("CUST_ZIP", "122016");
		map.put("MERCHANTNAME", "XYZ");
		map.put("ORDER_ID", "12333"); // Unique  
		map.put("PAY_ID", "1804100638381010");// provided by Acquirer 

		map.put("PRODUCT_DESC", "XYZ Product");
		map.put("RETURN_URL", "http://www.test.com/crm/jsp/response.jsp"); // customer call back url
		map.put("TXNTYPE", "SALE");

		// Secret Key eec2fd91c96b4ebb provided by Acquirer
		String hash = ChecksumUtils.generateCheckSum(map, "eec2fd91c96b4ebb");
		StringBuilder httpRequest = new StringBuilder();

		httpRequest.append("<HTML>");
		httpRequest.append("<BODY OnLoad=\"OnLoadEvent();\" >");
		httpRequest.append("<form name=\"form1\" action=\"");
		httpRequest.append("http://pg.test.com/crm/jsp/paymentrequest");
		httpRequest.append("\" method=\"post\">");

		httpRequest.append("<input type=\"hidden\" name=\"PAY_ID\" value=\"");
		httpRequest.append("1804100638381010");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"MERCHANTNAME\" value=\"");
		httpRequest.append("Demo");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"ORDER_ID\" value=\"");
		httpRequest.append("12333");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"AMOUNT\" value=\"");
		httpRequest.append("100");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"TXNTYPE\" value=\"");
		httpRequest.append("SALE");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"CUST_NAME\" value=\"");
		httpRequest.append("DEMO");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"CUST_STREET_ADDRESS1\" value=\"");
		httpRequest.append("XYZ");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"CUST_ZIP\" value=\"");
		httpRequest.append("122016");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"CUST_PHONE\" value=\"");
		httpRequest.append("8888888888");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"CUST_EMAIL\" value=\"");
		httpRequest.append("customer@gamil.com");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"PRODUCT_DESC\" value=\"");
		httpRequest.append("XYZ Product");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"CURRENCY_CODE\" value=\"");
		httpRequest.append("356");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"RETURN_URL\" value=\"");
		httpRequest.append("http://www.test.com/crm/jsp/response.jsp");
		httpRequest.append("\">");

		httpRequest.append("<input type=\"hidden\" name=\"HASH\" value=\"");
		httpRequest.append(hash);
		httpRequest.append("\">");

		httpRequest.append("</form>");
		httpRequest.append("<script language=\"JavaScript\">");
		httpRequest.append("function OnLoadEvent()");
		httpRequest.append("{document.form1.submit();}");
		httpRequest.append("</script>");
		httpRequest.append("</BODY>");
		httpRequest.append("</HTML>");

		httpRequest.toString();

	}

}