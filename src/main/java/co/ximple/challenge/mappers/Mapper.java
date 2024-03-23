package co.ximple.challenge.mappers;


public interface Mapper <E,R>{
    E recordToEntity(R record);

    R entityToRecord(E entity);
}
