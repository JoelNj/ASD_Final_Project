package org.example.survey.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.survey.dto.AssesmentDto;
import org.example.survey.model.Assesment;
import org.example.survey.model.AssesmentQuestion;
import org.example.survey.model.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-09T19:15:59-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class AssesmentMapperImpl implements AssesmentMapper {

    @Override
    public Assesment assesmentDtoToAssesment(AssesmentDto assesmentDto) {
        if ( assesmentDto == null ) {
            return null;
        }

        Assesment assesment = new Assesment();

        assesment.setUser( assesmentDto.user() );
        assesment.setId( assesmentDto.id() );
        assesment.setResult( assesmentDto.result() );
        assesment.setPercentage( assesmentDto.percentage() );

        return assesment;
    }

    @Override
    public AssesmentDto assesmentToAssesmentDto(Assesment assesment) {
        if ( assesment == null ) {
            return null;
        }

        User user = null;
        Long id = null;
        String result = null;
        Double percentage = null;
        List<AssesmentQuestion> assessmentQuestions = null;

        user = assesment.getUser();
        id = assesment.getId();
        result = assesment.getResult();
        percentage = assesment.getPercentage();
        List<AssesmentQuestion> list = assesment.getAssessmentQuestions();
        if ( list != null ) {
            assessmentQuestions = new ArrayList<AssesmentQuestion>( list );
        }

        AssesmentDto assesmentDto = new AssesmentDto( id, user, result, percentage, assessmentQuestions );

        return assesmentDto;
    }
}
