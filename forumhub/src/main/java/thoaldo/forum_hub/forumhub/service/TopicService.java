package thoaldo.forum_hub.forumhub.service;

import thoaldo.forum_hub.forumhub.model.Topic;
import thoaldo.forum_hub.forumhub.repository.TopicRepository;
import thoaldo.forum_hub.forumhub.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Topic getTopicById(Long id) {
        return topicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Topic not found with id: " + id));
    }

    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Long id, Topic topicDetails) {
        Topic topic = getTopicById(id);
        topic.setTitulo(topicDetails.getTitulo());
        topic.setMensagem(topicDetails.getMensagem());
        topic.setEstado(topicDetails.getEstado());
        topic.setCurso(topicDetails.getCurso());
        return topicRepository.save(topic);
    }

    public void deleteTopic(Long id) {
        Topic topic = getTopicById(id);
        topicRepository.delete(topic);
    }
}
