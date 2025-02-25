package idusw.soccerworld.repository;

import idusw.soccerworld.domain.dto.TeamDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamRepository {
    SqlSessionTemplate sqlSessionTemplate;

    public TeamRepository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public int insertTeam(List<TeamDto> teamDtoList){
        int result = sqlSessionTemplate.insert("TeamName.insertTeam",teamDtoList);
        return result;
    }

    public List<TeamDto> selectAll() {
        return sqlSessionTemplate.selectList("TeamName.selectAll");
    }
}
