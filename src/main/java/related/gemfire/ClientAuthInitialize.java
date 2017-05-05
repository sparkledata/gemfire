package related.gemfire;

import com.gemstone.gemfire.LogWriter;
import com.gemstone.gemfire.distributed.DistributedMember;
import com.gemstone.gemfire.security.AuthInitialize;
import com.gemstone.gemfire.security.AuthenticationFailedException;

import java.io.IOException;
import java.util.Properties;

public class ClientAuthInitialize implements AuthInitialize {
  private EnvParser env = EnvParser.getInstance();

  private static final String USER_NAME = "security-username";
  private static final String PASSWORD = "security-password";

  public static AuthInitialize create() {
    return new ClientAuthInitialize();
  }

  @Override
  public void close() {
  }

  @Override
  public Properties getCredentials(Properties arg0, DistributedMember arg1,
                                   boolean arg2) throws AuthenticationFailedException {
    Properties props = new Properties();
    try {
      String username = env.getUsername();
      String password = env.getPassword();
      props.put(USER_NAME, username);
      props.put(PASSWORD, password);
    } catch (IOException e) {
      throw new AuthenticationFailedException("Exception reading username/password from env variables ", e);
    }
    return props;
  }

  @Override
  public void init(LogWriter arg0, LogWriter arg1)
      throws AuthenticationFailedException {
  }
}