package idusw.soccerworld.domain.entity;

import idusw.soccerworld.domain.dto.PredictionDto;
import lombok.Data;


@Data
public class PredictionEntity {
    private long predictionId;
    private MemberEntity memberEntity;
    private GameEntity gameEntity;
    private int result;

    public static PredictionEntity dtoToEntity(PredictionDto predictionDto) {
        PredictionEntity predictionEntity = new PredictionEntity();
        predictionEntity.setPredictionId(predictionDto.getPredictionId());
        predictionEntity.setMemberEntity(MemberEntity.dtoToEntity(predictionDto.getMemberDto()));
        predictionEntity.setGameEntity(GameEntity.dtoToEntity(predictionDto.getGameDto()));
        predictionEntity.setResult(predictionDto.getResult());
        return predictionEntity;
    }
}
