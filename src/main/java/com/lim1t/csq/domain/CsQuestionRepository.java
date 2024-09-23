package com.lim1t.csq.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class CsQuestionRepository {

    private final DynamoDbTable<CsQuestion> csQuestionDynamoDbTable;

    public CsQuestionRepository(@Autowired DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.csQuestionDynamoDbTable = dynamoDbEnhancedClient.table("CsQuestion", TableSchema.fromBean(CsQuestion.class));
    }

    public void saveCsQuestion(CsQuestion CsQuestion) {
        csQuestionDynamoDbTable.putItem(CsQuestion);
    }

    public CsQuestion findCsQuestionById(String csQuestionId) {
        return csQuestionDynamoDbTable.getItem(
                Key.builder()
                        .partitionValue(csQuestionId)
                        .build()
        );
    }

    public void updateCsQuestion(CsQuestion CsQuestion) {
        csQuestionDynamoDbTable.updateItem(CsQuestion);
    }

    public void deleteCsQuestion(String csQuestionId) {
        csQuestionDynamoDbTable.deleteItem(
                Key.builder()
                        .partitionValue(csQuestionId)
                        .build()
        );
    }

    public List<CsQuestion> findAll() {
        return csQuestionDynamoDbTable.scan()
                .items()
                .stream()
                .toList();
    }

    public List<CsQuestion> getRandomCsQuestions(Integer limit) {
        List<CsQuestion> allQuestions = StreamSupport
                .stream(csQuestionDynamoDbTable.scan().items().spliterator(), false)
                .collect(Collectors.toList());

        Collections.shuffle(allQuestions);

        return allQuestions.stream()
                .limit(limit)
                .collect(Collectors.toList());
    }
}
