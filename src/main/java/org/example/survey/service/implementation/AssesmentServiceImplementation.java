package org.example.survey.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.survey.dto.AssesmentDto;
import org.example.survey.exception.user.RessourceNotFoundException;
import org.example.survey.mapper.AssesmentMapper;
import org.example.survey.model.Assesment;
import org.example.survey.model.Category;
import org.example.survey.model.User;
import org.example.survey.repository.AssesmentRepository;
import org.example.survey.repository.UserRepository;
import org.example.survey.service.AssesmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssesmentServiceImplementation implements AssesmentService {

    private final AssesmentMapper assesmentMapper;
    private final AssesmentRepository assesmentRepository;
    private final UserRepository userRepository;


    @Override
    public Optional<AssesmentDto> addAssesment(Long userId,AssesmentDto assesmentDto) {
        Assesment assesment = assesmentMapper.assesmentDtoToAssesment(assesmentDto);
        User user = userRepository.findById(userId).get();
        assesment.setUser(user);
        Assesment savedAssesment = assesmentRepository.save(assesment);
        return Optional.of(assesmentMapper.assesmentToAssesmentDto(savedAssesment));
    }

    @Override
    public Optional<AssesmentDto> updateAssesment(Long assesmentId, AssesmentDto assesmentDto) throws RessourceNotFoundException {
        Optional<Assesment> assesmentOptional = assesmentRepository.findById(assesmentId);
        if (assesmentOptional.isPresent()) {
            Assesment assesment = assesmentOptional.get();
            assesment.setResult(assesmentDto.result());
            assesment.setPercentage(assesmentDto.percentage());
            assesmentRepository.save(assesment);
            return Optional.of(assesmentMapper.assesmentToAssesmentDto(assesment));
        }
        throw  new RessourceNotFoundException("Assesment not found ");
    }


    @Override
    public void deleteAssesment(Long assesmentId) throws RessourceNotFoundException {
        Optional<Assesment> assesmentToDelete = assesmentRepository.findById(assesmentId);
        if(assesmentToDelete.isPresent()){
            assesmentRepository.delete(assesmentToDelete.get());
        }
        else{
            throw new RessourceNotFoundException("Assesment not found ");
        }
    }

    @Override
    public Optional<List<AssesmentDto>> getAllAssesments() {
        List<AssesmentDto> listOfAssesments = assesmentRepository.findAll().stream().map(assesmentMapper::assesmentToAssesmentDto).toList();
        return Optional.of(listOfAssesments);
    }

    @Override
    public Optional<List<AssesmentDto>> getListAssesmentByUserId(Long userId) throws RessourceNotFoundException {
        User  user = userRepository.findById(userId).get();
        List<AssesmentDto> listOfAssesments = assesmentRepository.findByUser(user).stream().map(assesmentMapper::assesmentToAssesmentDto).toList();
        return Optional.of(listOfAssesments);

    }

    @Override
    public Optional<AssesmentDto> getOneAssesmentById(Long assementId) throws RessourceNotFoundException {
        Optional<Assesment> assesment = assesmentRepository.findById(assementId);
        if(assesment.isPresent()){
            Assesment assesmentToReturn = assesment.get();
            return Optional.of(assesmentMapper.assesmentToAssesmentDto(assesmentToReturn)) ;
        }
        throw new RessourceNotFoundException("Assesment not found ");
    }
}
