package zg2pro;

import com.github.zg2pro.spring.safe.setup.fs.FsReady;
import com.github.zg2pro.spring.safe.setup.security.PreAuthorizeAllRemoteStrategy;
import zg2pro.services.PermissionCheckAnnotation;
import com.github.zg2pro.spring.safe.setup.utc.UtcVerifier;
import com.github.zg2pro.spring.safe.setup.utf8.Utf8Verifier;
import java.io.File;
import java.nio.file.FileSystemException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author zg2pro
 */
@SpringBootApplication
public class LibraryBoot {

    @Bean
    public Boolean checkHost() throws FileSystemException {
        FsReady.checkFileSystemIsReady(10, new File(System.getProperty("java.io.tmpdir")));
        UtcVerifier.checkHostTimezone();
        Utf8Verifier.checkHostEncoding();
        return true;
    }

    @Bean
    public Boolean checkSecurity() {
        PreAuthorizeAllRemoteStrategy paars = new PreAuthorizeAllRemoteStrategy(PermissionCheckAnnotation.class,
                PermissionCheckAnnotation.class.getPackage().getName() + ".one");
        paars.processVerification();
        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryBoot.class, args);
    }

}
