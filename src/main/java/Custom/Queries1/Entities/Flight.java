package Custom.Queries1.Entities;

@Entity
public class Flight {

    @Id
    @GenerateValue(strategy= GenerationType.AUTO)
    private long id;

    private String description;
    private String fromAirport;
    private String toAirport;

    @Enumerated(EnumType.STRING)
    private Status status;
}
