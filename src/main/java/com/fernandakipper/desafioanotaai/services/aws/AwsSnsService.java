package com.fernandakipper.desafioanotaai.services.aws;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Topic;
import org.apache.tomcat.util.json.JSONParser;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AwsSnsService {
    private AmazonSNS snsClient;
    private Topic catalogTopic;

    public AwsSnsService(AmazonSNS snsClient, @Qualifier("catalogEventsTopic") Topic catalogTopic){
        this.snsClient = snsClient;
        this.catalogTopic = catalogTopic;
    }

    public void publish(MessageDTO message){
        System.out.println(message.message());
        this.snsClient.publish(catalogTopic.getTopicArn(), message.message());
    }
}
