package de.isaccseven.resumereverence.persistence;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("employee")
public class EmployeeDAO {

    @Id
    private String id;
    @Column("firstname")
    private String firstName;
    @Column("lastname")
    private String lastName;
    @Column("department")
    private String department;
    @Column("position")
    private String position;
}
