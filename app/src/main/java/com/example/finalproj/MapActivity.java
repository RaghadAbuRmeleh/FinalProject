package com.example.finalproj;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MapActivity extends AppCompatActivity {
    private EditText searchEditText;
    private ListView facilitiesListView;
    private List<String> myListView;
    private List<String> originalFacilitiesList;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        facilitiesListView = findViewById(R.id.myListView);
        searchEditText = findViewById(R.id.searchEditText);

        myListView = new ArrayList<>();
        myListView.add("1- Omar Abdulhadi BUILDING/ BUSINESS AND ECONOMICS BUILDING 2/ (ABDULHADI)\nمبنى عمر عبد الهادي / مبنى الأعمال والاقتصاد 2");
        myListView.add("2- ABDULRAHMAN AL JERAISY BUILDING/ Business and ECONOMICS BUILDING (AL-JURAYSI)\nمبنى عبد الرحمن الجريسي / مبنى الأعمال والاقتصاد");
        myListView.add("3- NASEEB SHAHEEN BUILDING/ GRADUATE STUDIES BUILDING (N.SHAHEEN)\nمبنى نصيب شاهين مبنى الدراسات العليا");
        myListView.add("4- AZEEZ SHAHEEN BUILDING/ UNIVERSITY CLINIC (CLI)\nمبنى عزيز شاهين / عبادة الجامعة");
        myListView.add("5- FACULTY OF SCIENCE BUILDING (SCI)\nمبنى كلية العلوم");
        myListView.add("6- SAMIR ABDULHADI BUILDING/ SCIENCE BULDING - MATH WING (S.ABDULHADI)\nميني سمير عبد الهادي / كلية العلوم - جناح الرياضيات");
        myListView.add("7- BIRZEIT UNIVERSITY MUSEUM\nمتحف جامعة بيرزيت.");
        myListView.add("8- YUSUF AHMED ALGHANIM LIBRARY BUILDING/ MAIN LIBRARY (ALGHANIM)\nمبنى مكتبة يوسف أحمد القائم / المكتبة الرئيسية");
        myListView.add("9- KAMAL NASIR AUDITORIUM (KNH)\nقاعة الشهيد كمال ناصر");
        myListView.add("10- GABI BARAMKI BUILDING/ UNIVERSITY ADMINISTRATION (BARAMKI)\nمبنى جابي برامكي / إدارة الجامعة");
        myListView.add("11- OMAR AGGAD OF ENGINEERING BUILDING (AGGAD)\n مبنى عمر العقاد للهندسةمبنى عمر عبد الهادي / مبنى الأعمال والاقتصاد\n ");
        myListView.add("12- GENERAL WORKSHOPS AND GUARDS BUILDING \n مبنى الحرس الجامعي، ومشاغل عامة");
        myListView.add("13- ZUHEIR ALAMI Building/ Engineering Office and GENERAL SERVICES BUILDING (ALAMI) \n مبنى زهير العلمي / مبنى المكتب الهندسي والخدمات العامة");
        myListView.add(  "14- WALEED AND HELEN KATTAN BUILDING/ UNIVERSITY PRESIDENCY (KATTAN) \n مبنى وليد وهيلن قطان / رئاسة الجامعةمبنى عزيز شاهين / عبادة الجامعة");
        myListView.add( "15- LAW BUILDING (IDL) \n مبنى الحقوق");
        myListView.add( "16- SHEIKH RASHID BIN SAID AL-MAKTOUM BUILDING/ STUDENT COMPLEX (MAKTOUM) \n مبنى الشيخ راشد بن سعيد آل مكتوم مجمع الطلبة");
        myListView.add(  "17- ENGINEERING WORKSHOPS BUILDING (WKS) \n مبنى مشاغل الهندسة");
        myListView.add(  "18- RIAD TAWFIK AL SADIK BUILDING/LAW AND PUBLIC ADMINISTRATION BUILDING (ALSADIK) \n مبنی رياض توفيق الصادق مبنى الحقوق والإدارة العامة");
        myListView.add(  "19- SERVICES BUILDING \n ميني خدمات");
        myListView.add( "20- SAMIR AWEIDAH GARDEN - AL-SHURFAH GARDEN (SHG) \n حديقة سمير عويضة / حديقة الشرفة");
        myListView.add( "21- ALI EL-HAJ STADIUM (EL-HAJ) \n مدرج على الحاج");
        myListView.add( "22- MOHAMMAD OMRAN BAMIEH BUILDING/ EDUCATION BUILDING (BAMIEH) \n مبنی محمد عمران بامية / مبنى التربية");
        myListView.add(  "23- AZEEZ SHAHEEN BUILDING/ ARTS BUILDING (A.SHAHEEN) \n الآداب مبنى عزيز شاهين / مبنى |");
        myListView.add( "24- RIYADH HOUSING/ FEMALE DORMS (RIYADH) \n إسكان الرياض للطالبات");
        myListView.add( "25- NAJJAD ZEENNI IT OF EXCELLENCE BUILDING (ZEENNI) \n مبنى جاد زعني لتكنولوجيا المعلومات للتميز");
        myListView.add(   "26- SAID KHOURY BUILDING FOR DEVELOPMENT STUDIES (KHOURY) \n مبنى سعيد خوري لدراسات التنمية");
        myListView.add(   "27- KINGDOM OF BAHRAIN BUILDING FOR WOMEN STUDIES (BAHRAIN) \n مبنى مملكة البحرين الدراسات المرأة");
        myListView.add(   "28- MOHAMED BAMIEH AND WALEED KAYYALI BUILDING/ PHYSICAL EDUCATION BUILDING (GYM) \n مبنى محمد بامية ووليد كيالي / مبنى التربية الرياضية");
        myListView.add(       "29- MUNIB RASHID MASRI BUILDING/ INFORMATION TECHNOLOGY BUILDING (MASRI) \n مبنى منيب رشيد المصري / مبنى تكنولوجيا المعلومات");
        myListView.add(       "30- MOHAMMAd Masrouji Building for Media (MasrouJI) \n مبنى محمد المسروجي للإعلام");
        myListView.add(      "31- SHUKY AZEEZ SHAHEEN BUILDING/ UNIVERSITY HALLS BUILDING (SH SHAHEEN) \n مبنى شوقي عزيز شاهين قاعات الجامعة العامة");
        myListView.add(      "32- NASEEB AZEEZ SHAHEEN AUDITORIUM (NSA) \n مسرح نسيب عزيز شاهين");
        myListView.add(     "33- GHALEB YOUNIS BUILDING/ PHARMACY, NURSING AND HEALTH PROFESSIONS BUILDING (PNH) \n مبنی غالب يونس / مبنى الصيدلة والتمريض والمهن الصحية");
        myListView.add(   "34- SAMIH DARWAZAH INSTITUTE FOR PHARMACEUTICAL INDUSTRIES (DARWAZAH) \n معهد سميح دروزة للصناعات الدوائية");
        myListView.add(   "35- SAMIR AWEIDAH BUILDING/ ART, MUSIC AND DESIGN BUILDING (AWEIDAH) \n مبنى سمير عويضة / مبنى الفنون والموسيقى والتصميم");
        myListView.add("36- PALESTINIAN MUSEUM \n المتحف الفلسطيني");
        myListView.add("37- MUNIR ATALLAH SPORTS FIELD \n ملعب منير عطا الله");
        myListView.add("38- SPORTS FIELDS");
        myListView.add("39 - WATER RESERVOIR");
        myListView.add(    "40- ADMINISTRATION BUILDING (Admin) \n المبنى الإداري");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myListView);
        facilitiesListView.setAdapter(adapter);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, originalFacilitiesList);
        facilitiesListView.setAdapter(adapter);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                filterFacilities(editable.toString());
            }
        });
    }

    private void filterFacilities(String text) {
        List<String> filteredList = new ArrayList<>();
        for (String facility : originalFacilitiesList) {
            if (facility.toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(facility);
            }
        }
        updateFacilitiesList(filteredList);
    }

    private void updateFacilitiesList(List<String> filteredList) {
        adapter.clear();
        adapter.addAll(filteredList);
        adapter.notifyDataSetChanged();
    }
}