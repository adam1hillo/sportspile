package adamh.sportspile.domain.api;

import adamh.sportspile.domain.discipline.Discipline;
import adamh.sportspile.domain.discipline.DisciplineDao;
import adamh.sportspile.domain.dto.DisciplineFullInfo;
import adamh.sportspile.domain.dto.DisciplineName;

import java.util.List;
import java.util.Optional;

public class DisciplineService {

    private DisciplineDao disciplineDao = new DisciplineDao();

    public List<DisciplineName> findAllDisciplines() {
        return disciplineDao.findAll()
                .stream()
                .map(DisciplineMapper::map)
                .toList();
    }

    public Optional<DisciplineFullInfo> findById(int disciplineId) {
        return disciplineDao.findById(disciplineId)
                .map(DisciplineFullInfoMapper::map);
    }

    private static class DisciplineMapper {
        static DisciplineName map(Discipline discipline) {
            return new DisciplineName(
                    discipline.getId(),
                    discipline.getName()
            );
        }
    }

    private static class DisciplineFullInfoMapper {
        static DisciplineFullInfo map(Discipline discipline) {
            return new DisciplineFullInfo(
                    discipline.getId(),
                    discipline.getName(),
                    discipline.getDescription()
            );
        }
    }
}
