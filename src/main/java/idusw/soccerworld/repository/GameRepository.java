package idusw.soccerworld.repository;

import idusw.soccerworld.domain.dto.GameDto;
import idusw.soccerworld.domain.entity.GameEntity;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class GameRepository {
    SqlSessionTemplate sessionTemplate;

    public GameRepository (SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    public List<GameDto> selectAll() {
        return sessionTemplate.selectList("GameName.selectAll");
    }

    public List<GameDto> selectByDate(String date){
        System.out.println("repository:"+date);
        return sessionTemplate.selectList("GameName.selectByDate",date);
    }
    public GameDto selectByGameId(int GameId){
        return sessionTemplate.selectOne("GameName.selectByGameId",GameId);
    }

    public int insertGames(List<GameDto> gameDtoList){
        int result = sessionTemplate.insert("GameName.insertGames",gameDtoList);
        return result;
    }

}
