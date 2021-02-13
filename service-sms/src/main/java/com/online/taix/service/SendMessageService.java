package com.online.taix.service;

import com.online.taix.dao.AliMessageDao;
import com.online.taix.dto.AliMessageTemplate;
import com.online.taix.dto.TaixResult;
import com.online.taix.smsservice.AliNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class SendMessageService {

    static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<Integer,Object>();

    @Autowired
    AliMessageDao aliMessageDao;

    public TaixResult send(AliNote aliNote) {
        final Integer templateid = aliNote.getMessageData().getTemplateid();
        //从数据库拉取模板
        if(!concurrentHashMap.containsKey(templateid)){
            //拉取
            final AliMessageTemplate template = aliMessageDao.getTemplate(templateid);
            concurrentHashMap.put(templateid,template);
        }
        return TaixResult.success("发送成功");
    }
}
