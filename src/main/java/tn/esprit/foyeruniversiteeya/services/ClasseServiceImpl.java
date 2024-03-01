package tn.esprit.foyeruniversiteeya.services;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyeruniversiteeya.entities.Classe;
import tn.esprit.foyeruniversiteeya.entities.Department;
import tn.esprit.foyeruniversiteeya.repositories.ClasseRepository;
import tn.esprit.foyeruniversiteeya.repositories.DepartmentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ClasseServiceImpl implements IClasseService{

    ClasseRepository classeRepository;
    DepartmentRepository departmentRepository;
    @Override
    public Classe addClasse(Classe classe) {
          return classeRepository.save(classe);
    }

    @Override
    public Classe getClasse(long idClasse) {
       return classeRepository.findById(idClasse).orElse(null);
    }

    @Override
    public List<Classe> getAllClasse() {
        return classeRepository.retrieveDepartment();
    }

    @Override
    public void deleteClasse(long idClasse) {
        Classe classe = classeRepository.findById(idClasse).orElse(null);
        Department department = classe.getDepartment();
        department.setNombreClasses(department.getNombreClasses()-1);
        departmentRepository.save(department);
          classeRepository.deleteById(idClasse);
    }

    @Override
    public Classe updateClasse(Classe classe) {
        Classe cl = classeRepository.findById(classe.getIdClasse()).orElse(null);
        Department department = departmentRepository.findById(cl.getDepartment().getIdDepartment()).orElse(null);
        classe.setDepartment(department);
        return  classeRepository.save(classe);
    }

    @Override
    public List<Object[]> getAllClassesWithDepartments() {
        return classeRepository.findAllWithDepartments();
    }

    @Override
    public List<Classe> getClassesByNom(String nom) {
        return classeRepository.getbyname(nom);
    }

    @Override
    public Long statNumberofClasses() {
        return classeRepository.count();
    }

    @Override
    public List<Classe> getClasseOrderByCapacity() {
        return classeRepository.orderCap();
    }

    @Override
    public Long statNumberofClassesDispo(boolean etat) {
        return classeRepository.countByDisponibility(etat);
    }

    @Override
    public List<Classe> getClassesByAvailability(boolean etat) {
        return classeRepository.findByDisponibility(etat);
    }

    @Override
    public Classe addDepartmentClasse(Classe classe, Long idDepartment) {

        Department department =departmentRepository.findById(idDepartment).orElse(null);

        classe.setDepartment(department);
        department.setNombreClasses(department.getNombreClasses()+1);
           departmentRepository.save(department);

       return classeRepository.save(classe);


    }


}
