package br.com.bb.exemplo.springdemo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Size(min = 5, max = 100)
    private String firstName;
    private String lastName;
    @Email(message = "Email invalido")
    private String email;
    @Min(value = 18, message = "Age should not be less than 18")
    private Integer age;

    @Pattern(regexp = "[a-zA-z]{2}[0-9]{9}", message = "Código cpf inválido")
    private String cpf;

    @Pattern(regexp="^[a-zA-Z0-9]{3}.*", message = "A password precisa ter mais de 3 caracteres")
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
