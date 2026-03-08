package api_utiles;

public class API_Constants extends ReaderFiles{

    public static String Base_URI=configFileReader("baseURI");
    public static String Content_Type=configFileReader("contentType");
    public static String Header_Key=configFileReader("headerKey");
    public static String Header_Value=configFileReader("headerValue");
    public static String Post_Endpoint=configFileReader("postEndpoint");
    public static String Put_Endpoint=configFileReader("putEndpoint");
    public static String Patch_Endpoint=configFileReader("patchEndPoint");
    public static String Get_Endpoint=configFileReader("getEndpoint");
    public static String Delete_Endpoint=configFileReader("deleteEndpoint");

}
