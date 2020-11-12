package ghasemia;

/**
 * Assignment 3
 *
 * Program: Developing a class that models a multi-option question
 *
 * This class name is Question. It consists of 4 fields, 1 constructor, and
 * getter-setter of the fields.
 *
 * @author Amirmahdi Ghasemi, July 2020
 */
public class Question {

    /**
     * This is a private int, and its name is questionNum. The value of
     * questionNum is 1.
     */
    private int questionNum = 1;
    /**
     * This is a private String, and its name is questionText. The value of
     * questionText is "This is the question text".
     */
    private String questionText = "This is the question text.";
    /**
     * This is a private String array, and its name is options. The value of
     * option is "True","False".
     */
    private String[] options = {"True", "False"};
    /**
     * This is a private char, and its name is answer. It does not have a
     * default value.
     */
    private char answer;

    /**
     * This is a default constructor of Question class, and it contains 3
     * parameters that you can find them here.
     *
     * @param num
     * @param text
     * @param opts
     */
    public Question(int num, String text, String... opts) {
        setQuestionNum(num);
        setQuestionText(text);
        setOptions(opts);
    }

    /**
     * Creates a new question number with a given number, and the only condition
     * is the number cannot be 0 or less. If the number is 0 or less, it will
     * throw an exception.
     *
     * @param num
     */
    public void setQuestionNum(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Error: Must be greater than 0");
        } else {
            this.questionNum = num;
        }
    }

    /**
     * This method gets the QuestionNum that was entered by the user, and its
     * default is 1.
     *
     * @return QuestionNum
     */
    public int getQuestionNum() {
        return questionNum;
    }

    /**
     * Creates a new question text with a given text, and the only condition is
     * the text cannot be null or empty. If the text is empty or null, it will
     * throw an exception.
     *
     * @param text
     */
    public void setQuestionText(String text) {
        if (" ".equals(text) || text == null) {
            throw new IllegalArgumentException("Error: this is the question text,"
                    + " Can't be null or empty");
        } else {
            this.questionText = text;
        }
    }

    /**
     * This method gets the QuestionText that was entered by the user, and its
     * default is "This is the question text".
     *
     * @return QuestionText
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Creates a new String array of options with a given options, and the only
     * condition is the text cannot be less than 2 options. If the options are
     * less than two, it will throw an exception. You can find the exception in
     * the main class.
     *
     * @param opts
     */
    public void setOptions(String... opts) {
        this.options = opts;
    }

    /**
     * This method gets the String array of options that was entered by the
     * user, and its default is "True","False".
     *
     * @return String array of options
     */
    public String[] getOptions() {
        return options;
    }

    /**
     * This method will take parameter from the user who takes the quiz, and it
     * will compare that answer to the available options. If the user enter
     * something which does not exist in the options will throw an exception.
     *
     * @param answer
     */
    public void setAnswer(char answer) {
        char firstLetter = getOptions()[getOptions().length - 1].charAt(0);
        if ((double) answer > (double) Character.toUpperCase(firstLetter)) {
            throw new IllegalArgumentException("Error: The answer must"
                    + "be one of the options.");
        } else {
            this.answer = answer;
        }
    }

    /**
     * This method gets char of the answer that was entered by the user.
     *
     * @return char of the answer
     */
    public char getAnswer() {
        return answer;
    }

    /**
     * This method compares the guess of the user with actual answer, and it
     * will return true if they are same.
     *
     * @return true or false
     */
    public boolean isCorrect(char guess) {
        if (getAnswer() == guess) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method returns the string value of the correct option. For example,
     * using the default options, getCorrectOption('b') would return "False".
     *
     * @param guess
     */
    public String getCorrectOption(char guess) {
        return String.valueOf(getAnswer());
    }

    /**
     * This method toString represents how a question will be formatted.
     *
     * @return this String
     */
    @Override
    public String toString() {
        String outPut = getQuestionNum() + ": " + getQuestionText() + "\n";
        for (String option : getOptions()) {
            outPut += option + "\n";
        }
        outPut += "Answer: ";
        return outPut;
    }

}
