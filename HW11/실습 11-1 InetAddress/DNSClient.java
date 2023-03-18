import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

public class DNSClient {

    public static Optional<String> query(String a) {
        try {
            InetAddress address = InetAddress.getByName(a);
            Optional<String> name = Optional.of(address.getHostAddress());
            return name;

        }catch (UnknownHostException e){
            Optional <String> name = Optional.empty();
            name = Optional.of(a+"\t"+": Name or service not known.");
            return name;
        }
    }
}
