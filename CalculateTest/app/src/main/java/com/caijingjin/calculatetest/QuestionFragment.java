package com.caijingjin.calculatetest;


import android.app.Activity;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.SavedStateVMFactory;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caijingjin.calculatetest.databinding.FragmentQuestionBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {


    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_question, container, false);
        FragmentActivity currentActivity = requireActivity();
        final MyViewModel myViewModel = ViewModelProviders.of(currentActivity,new SavedStateVMFactory(currentActivity)).get(MyViewModel.class);
        myViewModel.generator();
        myViewModel.getCurrentScore().setValue(0);
        final FragmentQuestionBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_question,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(currentActivity);
        final StringBuilder builder = new StringBuilder();
        //设置监听事件
        MyListener myListener = new MyListener(builder,binding);
        binding.button0.setOnClickListener(myListener);
        binding.button1.setOnClickListener(myListener);
        binding.button2.setOnClickListener(myListener);
        binding.button3.setOnClickListener(myListener);
        binding.button4.setOnClickListener(myListener);
        binding.button5.setOnClickListener(myListener);
        binding.button6.setOnClickListener(myListener);
        binding.button7.setOnClickListener(myListener);
        binding.button8.setOnClickListener(myListener);
        binding.button9.setOnClickListener(myListener);
        binding.buttonClear.setOnClickListener(myListener);

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(builder.length() == 0){
                    builder.append("-1");
                    return ;
                }
                if(myViewModel.getAnswer().getValue() == Integer.valueOf(builder.toString()).intValue()){
                    myViewModel.answerCorrect();
                    builder.setLength(0);
                    binding.textView15.setText(getString(R.string.answer_correct_message));
                }else{
                    NavController controller = Navigation.findNavController(view);
                    if(myViewModel.win_flag){
                        controller.navigate(R.id.action_questionFragment_to_winFragment);
                        myViewModel.win_flag = false;
                        myViewModel.save();
                    }else{
                        controller.navigate(R.id.action_questionFragment_to_loseFragment);
                    }
                }
            }
        });
        return binding.getRoot();
    }

    class MyListener implements View.OnClickListener {

        StringBuilder  builder;

        FragmentQuestionBinding binding;

        public MyListener(StringBuilder builder,FragmentQuestionBinding binding) {
            this.builder = builder;
            this.binding = binding;
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button0:
                    this.builder.append("0");
                    break;
                case R.id.button1:
                    this.builder.append("1");
                    break;
                case R.id.button2:
                    this.builder.append("2");
                    break;
                case R.id.button3:
                    this.builder.append("3");
                    break;
                case R.id.button4:
                    this.builder.append("4");
                    break;
                case R.id.button5:
                    this.builder.append("5");
                    break;
                case R.id.button6:
                    this.builder.append("6");
                    break;
                case R.id.button7:
                    this.builder.append("7");
                    break;
                case R.id.button8:
                    this.builder.append("8");
                    break;
                case R.id.button9:
                    this.builder.append("9");
                    break;
                case R.id.buttonClear:
                    this.builder.setLength(0);
                    break;
            }
            if(builder.length() == 0){
                binding.textView15.setText(R.string.input_indicator);
            }else{
                binding.textView15.setText(builder.toString());
            }
        }
    }

}
