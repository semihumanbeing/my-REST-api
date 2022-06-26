package com.myrestapi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myrestapi.model.UserProfile;

@Mapper
public interface UserProfileMapper {
	
	@Select("select * from UserProfile where id=#{id}")
	UserProfile getUserProfile(@Param("id") String id);
	
	@Select("select * from UserProfile")
	List<UserProfile> getUserProfileList();
	
	@Insert("insert into UserProfile values(#{id},#{name},#{phone},#{address})")
	int insertUserProfile(@Param("id")String id, 
						@Param("name")String name, 
						@Param("phone") String phone, 
						@Param("address") String address);
	
	@Update("update UserProfile set name=#{name}, phone=#{phone}, address=#{address} where id=#{id}")
	int updateUserProfile(@Param("id")String id, 
					   @Param("name")String name, 
					   @Param("phone") String phone, 
					   @Param("address") String address);
	
	@Delete("delete from UserProfile where id=#{id}")
	int deleteUserProfile(@Param("id") String id);
	
	
}
