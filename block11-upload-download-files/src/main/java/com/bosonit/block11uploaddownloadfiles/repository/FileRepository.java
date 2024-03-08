/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block11uploaddownloadfiles.repository;

import com.bosonit.block11uploaddownloadfiles.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FileRepository interface. Extends from JpaRepository and contains all methods related to File's persistence.
 */
public interface FileRepository extends JpaRepository<File, Long> {
    /*
    Thanks to extending from JpaRepository, we can persist and read data (Access to CRUD and query methods).
    <File, Long>
        File -> Defines entity to persist.
        Long -> Defines entity's primary key type.
     */

    // Other methods
    File findByName(String name);
}
