/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block11uploaddownloadfiles.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * File class. Defines a file in our program.
 */
@Entity
@Table(name = "File")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class File {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private Date uploadDate;

    private String category;
}
