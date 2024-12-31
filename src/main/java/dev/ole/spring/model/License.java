package dev.ole.spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "licenses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class License {

    @Id
    String id;
    String name;
    String key;
    String product;
    long expirationDate; //if -1, it means it never expires

    public boolean isExpired() {
        return expirationDate != -1 && expirationDate < System.currentTimeMillis();
    }

    public boolean isValid() {
        return !isExpired();
    }
}
