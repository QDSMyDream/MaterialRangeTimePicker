# MaterialRangeTimePicker


      //集成com.borax12.materialdaterangepicker:library:2.0 和com.wdullaer:materialdatetimepicker:4.2.3 实现时间选择框单选和多选
    
   
      日期单选使用 DatePickerDialog  
      日期多选 DatePickerRangeDialog
      
      时间单选 TimePickerDialog
      时间多选 TimePickerRangeDialog



---------------依赖说明-----------------
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  
	dependencies {
	        implementation 'com.github.QDSMyDream:MaterialRangeTimePicker:2.0'
	}
