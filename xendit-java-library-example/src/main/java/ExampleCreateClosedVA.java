import com.xendit.Xendit;
import com.xendit.enums.BankCode;
import com.xendit.exception.XenditException;
import com.xendit.model.VirtualAccount;

import java.util.HashMap;
import java.util.Map;

public class ExampleCreateClosedVA {
    public static void main(String[] args) {
        Xendit.apiKey = "xnd_development_...";

        Map<String, Object> closedVAMap = new HashMap<String, Object>();
        closedVAMap.put("external_id", "my_external_id");
        closedVAMap.put("bank_code", BankCode.BNI.getText());
        closedVAMap.put("name", "John Doe");
        closedVAMap.put("expected_amount", "200000000");

        try {
            /**
             * First option. Create directly from a properly named hashmap key value pair.
             * Check https://xendit.github.io/apireference/#create-fixed-virtual-accounts for field name.
             */
            VirtualAccount virtualAccount = VirtualAccount.createClosed(closedVAMap);

            /**
             * Second option. Create with individual value of required params.
             */
            VirtualAccount virtualAccount2 = VirtualAccount.createClosed("my_external_id",
                    BankCode.PERMATA.getText(), "John Doe", 100000L);

            /**
             * Third option. Create with individual value of required params plus added additional params at the end.
             */
            VirtualAccount virtualAccount3 = VirtualAccount.createClosed("my_external_id",
                    BankCode.MANDIRI.getText(), "John Doe", 100000L, closedVAMap);

            System.out.println(virtualAccount);
        } catch (XenditException e) {
            e.printStackTrace();
        }
    }
}
