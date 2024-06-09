package com.nhom29.Service.Impl;
import com.nhom29.Model.ERD.Tag;
import com.nhom29.Repository.TagRepository;
import com.nhom29.Service.Inter.TagInter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TagService implements TagInter {
    // contructor repo
    private final TagRepository tagRepo;
    @Override
    public List<Tag> getAllTag() {
        return tagRepo.findAll();
    }

    @Override
    public Tag saveTag(String tag, List<Tag> tags) {
        try{
            Optional<Tag> t = tags.stream().filter( temp -> temp.getTenTag().trim().equals(tag)).findFirst();
            if( t.isPresent() ) return t.get();
            else{
                Tag tagNew = new Tag();
                tagNew.setTenTag(tag);
                return tagRepo.save(tagNew);
            }
        }catch (Exception ex){
            log.warn(ex.getMessage());
            return null;
        }
    }

    @Override
    public Tag saveTagALl(Tag tag, List<Tag> tags)
    {
        try {
            if(tag.getTenTag().isEmpty() || tag.getNoidung().isEmpty())
            {
                throw new RuntimeException("tieu de va noi dung khong duoc trong!");
            }
            String tagName = tag.getTenTag().toLowerCase();
            Tag existTag = null;
            for (Tag item : tags) {
                if(item.getTenTag().toLowerCase().equals(tagName))
                {
                    existTag = item;
                    break;
                }
            }
            if(existTag != null)
            {
                existTag.setNoidung(tag.getNoidung());
                existTag.setThoigiantao(LocalDateTime.now());
                return tagRepo.save(existTag);
            }
            else
            {
                tag.setThoigiantao(LocalDateTime.now());
                return tagRepo.save(tag);
            }
        }
        catch (Exception ex)
        {
            log.warn(ex.getMessage());
            return null;
        }
    }

    @Override
    public Tag getTagByName(String name) {
        Optional<Tag> tag = tagRepo.findTagByName(name);
        if( tag.isEmpty()) return null;
        return tag.get();
    }

//    .withSort(Sort.by(feild).descending())

    @Override
    public Page<Tag> phanTrangTag(int offset, int pageSize, String sort){

        if(sort.equals("macdinh"))
        {
            return tagRepo.findAll(PageRequest.of(offset, pageSize));
        }

        return tagRepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(sort).descending()));
    }
}
