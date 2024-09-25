package fpmislata.domain.model;

import java.util.UUID;

import lombok.Data;
import lombok.NonNull;

@Data
public class Actor {

    @NonNull
    private UUID id;
    @NonNull
    private String name;
    @NonNull
    private String surname;
}