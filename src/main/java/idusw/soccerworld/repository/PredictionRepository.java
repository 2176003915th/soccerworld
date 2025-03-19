package idusw.soccerworld.repository;

import idusw.soccerworld.domain.dto.GameDto;
import idusw.soccerworld.domain.dto.PredictionDto;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PredictionRepository {
    SqlSessionTemplate sessionTemplate;

    public PredictionRepository(SqlSessionTemplate sqlSessionTemplate){
        this.sessionTemplate = sqlSessionTemplate;
    }

    public PredictionDto selectByPrediction(PredictionDto predictionDto) {
        return sessionTemplate.selectOne("PredictionMapper.checkPrediction",predictionDto);
    }

    public void insert(PredictionDto predictionDto){
        sessionTemplate.insert("PredictionMapper.insertPrediction",predictionDto);
    }

    public List<PredictionDto> selectByGameList(@Param("gameEntityList")List<GameDto> gameDtoList) {
        return sessionTemplate.selectList("PredictionMapper.selectPredictionsByGameId",gameDtoList);
    }

}
