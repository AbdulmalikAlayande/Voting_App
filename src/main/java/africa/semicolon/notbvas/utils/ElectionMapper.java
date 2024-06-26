package africa.semicolon.notbvas.utils;

import africa.semicolon.notbvas.data.dtos.request.ElectionRequest;
import africa.semicolon.notbvas.data.dtos.response.ElectionResponse;
import africa.semicolon.notbvas.data.models.Election;

public class ElectionMapper {
	public static ElectionResponse map(Election foundElection) {
		return ElectionResponse.builder()
				       .endTime(foundElection.getEndTime())
				       .electionDate(foundElection.getElectionDate())
				       .electionType(foundElection.getElectionType())
				       .numberOfCandidates(foundElection.getNumberOfCandidates())
				       .startTime(foundElection.getStartTime())
				       .winnerName(foundElection.getWinnerName())
				       .winnerParty(foundElection.getWinnerParty())
				       .electionId(foundElection.getId())
				       .ongoing(foundElection.isOngoing())
				       .build();
	}
	public static Election map(ElectionRequest electionRequest) {
		return Election.builder()
				       .endTime(electionRequest.getEndTime())
				       .electionType(electionRequest.getElectionType())
				       .numberOfCandidates(electionRequest.getNumberOfCandidates())
				       .startTime(electionRequest.getStartTime())
				       .build();
	}
}
