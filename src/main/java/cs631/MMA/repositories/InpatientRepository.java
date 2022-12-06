package cs631.MMA.repositories;

import cs631.MMA.entities.Inpatient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/clinic")
public interface InpatientRepository extends CrudRepository<Inpatient, Integer> {
}
