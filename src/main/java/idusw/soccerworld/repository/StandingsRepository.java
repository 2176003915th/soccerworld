package idusw.soccerworld.repository;

import idusw.soccerworld.domain.dto.StandingsDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StandingsRepository {
    SqlSessionTemplate sessionTemplate;

    public StandingsRepository(SqlSessionTemplate sqlSessionTemplate){
        this.sessionTemplate = sqlSessionTemplate;
    }
    public int insertStanding(List<StandingsDto> standingsDtoList) {
        int result = sessionTemplate.insert("StandingsMapper.insertStandings",standingsDtoList);
        return result;
    }

}
