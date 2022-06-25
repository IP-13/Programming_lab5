package lab5.storedClasses;

import lab5.utils.GenerateId;

/**
 * Represents event
 */
public class Event {
    private Integer id = GenerateId.generateEventId(); //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String description; //Поле не может быть null
    private EventType eventType; //Поле может быть null

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Event(Integer id, String name, String description, EventType eventType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.eventType = eventType;
    }

    public Event(String name, String description, EventType eventType) {
        this.name = name;
        this.description = description;
        this.eventType = eventType;
    }

    public String toString() {
        return "Event Id: " + id + " " +
                "Event Name: " + name + " " +
                "Event Description: " + description + " " +
                "Event Type: " + eventType + " ";
    }

    @Override
    public int hashCode() {
        if (eventType == null) {
            return id + name.hashCode() + description.hashCode();
        }
        return id + name.hashCode() + description.hashCode() + eventType.hashCode();
    }
}
