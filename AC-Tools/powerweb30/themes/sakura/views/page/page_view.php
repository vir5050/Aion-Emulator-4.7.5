<div class="note">
	<div class="note_body h15 img">
		<div class="note_title">
			<?php echo $model->title; ?>
			<?php if (!Yii::app()->user->isGuest AND Yii::app()->user->access_level >= Config::get('access_level_editor')): ?><a class="edit" title="Редактировать" href="<?php echo Yii::app()->homeUrl.'page/edit/'.$model->id; ?>"></a><?php endif; ?>
		</div>
		<?php echo htmlspecialchars_decode($model->text); ?>
	</div>
</div>