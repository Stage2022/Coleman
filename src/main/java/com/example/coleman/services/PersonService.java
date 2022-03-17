package com.example.coleman.services;

import com.example.coleman.beans.Person;
import com.example.coleman.beans.Survey;
import com.example.coleman.exceptions.DuplicateException;
import com.example.coleman.exceptions.NotFoundException;
import com.example.coleman.repository.PersonRepository;
import com.example.coleman.repository.SurveyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PersonService {
    static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);
    @Autowired
    SurveyService surveyService;

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    PersonRepository personRepository;
    
    public List<Person> addToSurvey(Long idsurvey, List<Person> units) {
        // check and retrieval of the survey
        Survey survey = surveyRepository.findById(idsurvey)
                .orElseThrow(() -> new NotFoundException("survey", idsurvey));
        LOGGER.info(survey.toString());
        List<Person> unitAdded = new ArrayList<Person>();
        for (Person unit : units) {
            try {
                Person unitAdd = addToSurveyIndiv(idsurvey,unit);
                unitAdded.add(unitAdd);
                LOGGER.info("Unit : " + unit.toString());
            } catch (DuplicateException e){
                e.getMessage();
            }
        }
        return unitAdded;

    }

    public Person addToSurveyIndiv(Long idsurvey, Person unit){
        // On va considérer ici qu'une personne participe à une enquete à la fois
        if (unit.getIdSurvey() != null){
            throw new DuplicateException("unit in survey", unit.getIdSurvey());
        } else {
            unit.setIdSurvey(idsurvey);
            return unit;
        }
    }

}
