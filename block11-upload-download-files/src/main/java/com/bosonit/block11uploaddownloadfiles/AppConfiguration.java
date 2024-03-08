/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block11uploaddownloadfiles;

import com.bosonit.block11uploaddownloadfiles.application.implementations.FileServiceImpl;
import com.bosonit.block11uploaddownloadfiles.application.services.IFileService;
import com.bosonit.block11uploaddownloadfiles.domain.File;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AppConfiguration class. Defines all Beans for the project to run.
 */
@Configuration
public class AppConfiguration {
    // Beans
    @Bean
    public IFileService<File> fileService() {
        return new FileServiceImpl();
    }
}
