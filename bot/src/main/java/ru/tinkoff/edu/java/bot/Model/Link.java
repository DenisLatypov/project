package ru.tinkoff.edu.java.bot.Model;

import java.net.URI;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Link {
    private long id;
    private URI url;

    public Link(long id, URI url) {
        this.id = id;
        this.url = url;
    }


}
