package space.purchases;

import java.util.Base64;
import java.util.Base64.Decoder;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;

public class PayPal {

    static String id = "AVvHsnP6RKt8kn-3K59G4-2qJAIvl58V9OIpU8iB4nO8carlUb2WQT_LtUFrKwAcc5oNJ9R0kOjfSF9j";
    static String secret = "EOPVXUU0X8H1lK5YQ1ftox1KynB6EbUhoCF7DJIkIOXbtGc30oSsy-n7nYQQmBg3MKUfcv8aqGVzAcXC";
    
    private static PayPalEnvironment environment = new PayPalEnvironment.Sandbox(id, secret);

    public static PayPalHttpClient client = new PayPalHttpClient(environment);
}