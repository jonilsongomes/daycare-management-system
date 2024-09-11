package em.dio.daycare_management_system.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import em.dio.daycare_management_system.domain.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

}
