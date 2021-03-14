package com.example.server.entity;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @Column(name = "id_emp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_phone")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "id_pos", foreignKey = @ForeignKey(name = "EMPLOYEE_POSITION_FK"))
    private Position position;

    public Employee(Long empId, String name, String phone, Position position) {
        this.empId = empId;
        this.name = name;
        this.phone = phone;
        this.position = position;
    }

    public Employee() {
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
