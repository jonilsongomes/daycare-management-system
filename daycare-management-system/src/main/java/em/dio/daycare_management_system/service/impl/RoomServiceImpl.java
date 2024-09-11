package em.dio.daycare_management_system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import em.dio.daycare_management_system.domain.model.Room;
import em.dio.daycare_management_system.domain.repository.RoomRepository;
import em.dio.daycare_management_system.service.RoomService;


@Service
public class RoomServiceImpl implements RoomService{
	
	/**
     * ID de usuário utilizado na Santander Dev Week 2023.
     * Por isso, vamos criar algumas regras para mantê-lo integro.
     */
    private static final Long UNCHANGEABLE_USER_ID = 1L;
    
    private final RoomRepository repository;
    
    

	public RoomServiceImpl(RoomRepository repository) {
		super();
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Room> findAll() {
		// TODO Auto-generated method stub
		return this.repository.findAll();
	}

	@Override
	public Room findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room create(Room entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public Room update(Long id, Room entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
