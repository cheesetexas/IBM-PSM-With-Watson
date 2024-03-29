package ucl.ac.uk.ibmpsmwithwatson.util;

import ucl.ac.uk.ibmpsmwithwatson.pojo.dto.EventQueryDTO;
import ucl.ac.uk.ibmpsmwithwatson.pojo.dto.RecordQueryDTO;
import ucl.ac.uk.ibmpsmwithwatson.pojo.po.Questionnaire;
import ucl.ac.uk.ibmpsmwithwatson.pojo.po.Template;
import ucl.ac.uk.ibmpsmwithwatson.pojo.vo.EventVO;
import ucl.ac.uk.ibmpsmwithwatson.pojo.vo.RecordVO;
import ucl.ac.uk.ibmpsmwithwatson.pojo.vo.UserVO;

import java.util.List;

public class SearchingUtil {
    public static void searchingUser(List<UserVO> list, String searchInput) {
        if(!searchInput.equals("")) {
            if(searchInput.matches("[a-zA-Z]+")) {
                searchInput = searchInput.toLowerCase();
                for(int i = list.size() - 1; i >= 0; i--) {
                    UserVO userVO = list.get(i);
                    String givenName = userVO.getGiven_name().toLowerCase();
                    String familyName = userVO.getFamily_name().toLowerCase();
                    if(!givenName.contains(searchInput) && !familyName.contains(searchInput)) {
                        list.remove(userVO);
                    }
                }
            } else {
                list.clear();
            }
        }
    }

    public static void searchingTemplate(List<Template> list, String searchInput) {
        if(!searchInput.equals("")) {
            for(int i = list.size() - 1; i >= 0; i--) {
                Template template = list.get(i);
                if(!template.getId().equals(searchInput) &&
                        !template.getTitle().toLowerCase().contains(searchInput)) {
                    list.remove(template);
                }
            }
        }
    }

    public static void searchingQuestionnaire(List<Questionnaire> list, String searchInput) {
        if(!searchInput.equals("")) {
            for(int i = list.size() - 1; i >= 0; i--) {
                Questionnaire questionnaire = list.get(i);
                if(!questionnaire.getId().equals(searchInput) &&
                        !questionnaire.getTitle().toLowerCase().contains(searchInput)) {
                    list.remove(questionnaire);
                }
            }
        }
    }

    public static void searchingRecord(List<RecordVO> list, RecordQueryDTO dto) {
        if(!dto.getSearchInput().equals("")) {
            for(int i = list.size() - 1; i >= 0; i--) {
                RecordVO recordVO = list.get(i);
                if(!recordVO.getId().equals(dto.getSearchInput()) &&
                        !recordVO.getQuestionnaire().getTitle().toLowerCase().contains(dto.getSearchInput())) {
                    list.remove(recordVO);
                }
            }
        }
        if(!dto.getPatientFilter().equals("")) {
            for(int i = list.size() - 1; i >= 0; i--) {
                RecordVO recordVO = list.get(i);
                if(!recordVO.getCreatorId().equals(dto.getPatientFilter())) {
                    list.remove(recordVO);
                }
            }
        }
        if(!dto.getResultFilter().equals("")) {
            for(int i = list.size() - 1; i >= 0; i--) {
                RecordVO recordVO = list.get(i);
                if(!recordVO.getQuestionnaire().getResult().equals(dto.getResultFilter())) {
                    list.remove(recordVO);
                }
            }
        }
        if(!dto.getNeedMeetingFilter().equals("")) {
            for(int i = list.size() - 1; i >= 0; i--) {
                RecordVO recordVO = list.get(i);
                if(!recordVO.getQuestionnaire().getNeedMeeting().equals(dto.getNeedMeetingFilter())) {
                    list.remove(recordVO);
                }
            }
        }
    }

    public static void searchingEvent(List<EventVO> list, EventQueryDTO dto) {
        if(!dto.getSearchInput().equals("")) {
            for(int i = list.size() - 1; i >= 0; i--) {
                EventVO eventVO = list.get(i);
                if(!eventVO.getId().equals(dto.getSearchInput()) &&
                        !eventVO.getTitle().toLowerCase().contains(dto.getSearchInput())) {
                    list.remove(eventVO);
                }
            }
        }
    }
}
