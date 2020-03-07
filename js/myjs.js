
$(document).ready(function(){
    var LDate = new Date();
    var LDateHour = LDate.getHours();
    if(LDateHour>10){
       // $("form").hide();
       // alert("过了十点啦");
    }
    var localT = LDate.toLocaleString();
    $("#localtime").attr("value",localT);


    $('#submit').on('click', function() {

        //var arr = $('form').serializeArray();
        //var tempObj = {};
        //$.each(arr, function() {
        //    tempObj[this.name] = this.value;
        //});
        //alert(JSON.stringify(tempObj));
        //alert(tempObj.Plist1);


        $(" td[id = 'table_Plist1']").text($(" input[ name='Plist1' ] ").val());
        $(" td[id = 'table_Plist2']").text($(" input[ name='Plist2' ] ").val());
        $(" td[id = 'table_Plist3']").text($(" input[ name='Plist3' ] ").val());
        $(" td[id = 'table_Plist4']").text($(" input[ name='Plist4' ] ").val());
        $(" td[id = 'table_Plist5']").text($(" input[ name='Plist5' ] ").val());
        $(" td[id = 'table_Plist6']").text($(" input[ name='Plist6' ] ").val()+" "
            + $(" input[ name='Plist7' ] ").val()+" "
            + $(" input[ name='Plist8' ] ").val());
        $(" td[id = 'table_Plist7']").text($(" input[ name='list1' ]:checked ").val());
        $(" td[id = 'table_Plist8']").text($(" input[ name='list2' ]:checked ").val());
        $(" td[id = 'table_Plist9']").text($(" input[ name='list3' ]:checked ").val());
        $(" td[id = 'table_Plist10']").text($(" input[ name='list4' ]:checked ").val());
        $(" td[id = 'table_Plist11']").text($(" input[ name='list5' ]:checked ").val());
        $(" td[id = 'table_Plist12']").text($(" input[ name='list6' ]:checked ").val());
        $(" td[id = 'table_Plist13']").text($(" input[ name='list7' ]:checked ").val());
        $(" td[id = 'table_Plist14']").text($(" input[ name='other' ] ").val());
        $("#table_p").css("display","block");
        $("#MainForm").css("display","none");
    });



});

