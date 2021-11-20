### SNS New Order Event ###
printf "Creating New Order SNS topic..."
new_order_sns_topic=$(awslocal sns create-topic \
      --name NewOrderTopic \
      --output text)

echo "Topic ARN $new_order_sns_topic"

printf "Finished"