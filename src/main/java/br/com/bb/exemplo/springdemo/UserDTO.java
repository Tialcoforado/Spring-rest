package br.com.bb.exemplo.springdemo;

public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String cpf;

    public UserDTO(String email, String firstName, String lastName, String cpf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cpf = cpf;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }
}
